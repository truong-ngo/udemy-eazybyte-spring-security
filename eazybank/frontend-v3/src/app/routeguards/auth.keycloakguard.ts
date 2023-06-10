import { Injectable } from "@angular/core";
import { KeycloakAuthGuard, KeycloakService } from "keycloak-angular";
import { User } from "../model/user.model";
import { KeycloakProfile } from "keycloak-js";
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from "@angular/router";

@Injectable({
    providedIn: "root"
})
export class AuthKeycloakGuard extends KeycloakAuthGuard {
    user = new User();
    public userProfile: KeycloakProfile | null = null;
    constructor(
        protected override readonly router: Router,
        protected readonly keycloak: KeycloakService
    ) {
        super(router, keycloak)
    }

    public async isAccessAllowed(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ) {
        if (!this.authenticated) {
            await this.keycloak.login({
              redirectUri: window.location.origin + state.url,
            });
            return Promise.resolve(false);
        } else {
            this.userProfile = await this.keycloak.loadUserProfile();
            this.user.authStatus = "AUTH";
            this.user.name = this.userProfile.firstName || "";
            this.user.email = this.userProfile.email || "";
            window.sessionStorage.setItem("userdetails", JSON.stringify(this.user))
        }

        const requiredRoles = route.data["roles"];

        if (!(requiredRoles instanceof Array) || requiredRoles.length === 0) {
            return true;
        }

        return requiredRoles.some(role => this.roles.includes(role));
        // const keycloakInstance = this.keycloak.getKeycloakInstance();
        // console.log(keycloakInstance);
        
        // return new Promise<boolean>(resolve => {
                  
        //     keycloakInstance.onReady = async (authenticated) => {
                          
        //         if (!authenticated) {
        //             await this.keycloak.login({
        //                 redirectUri: window.location.origin + state.url
        //             });
        //             resolve(false);
        //             return;
        //         } else {
        //             this.userProfile = await this.keycloak.loadUserProfile();             
        //             this.user.authStatus = 'AUTH';
        //             this.user.name = this.userProfile.firstName || "";
        //             this.user.email = this.userProfile.email || "";
        //             window.sessionStorage.setItem("userdetails", JSON.stringify({...this.user}));
        //         }

        //         console.log("ok");
                

        //         // Get the roles required from the route.
        //         const requiredRoles = route.data["roles"] as string[];

        //         console.log(route);
                

        //         // Allow the user to to proceed if no additional roles are required to access the route.
        //         // noinspection SuspiciousTypeOfGuard
        //         if (!(requiredRoles instanceof Array) || requiredRoles.length === 0) {
        //             resolve(true);
        //             return;
        //         }

        //         // Allow the user to proceed if all the required roles are present.
        //         console.log(requiredRoles.some((role) => this.roles.includes(role)));
                
        //         resolve(requiredRoles.some((role) => this.roles.includes(role)));
        //     };

        //     keycloakInstance.onReady();
        // });
        
    }
}