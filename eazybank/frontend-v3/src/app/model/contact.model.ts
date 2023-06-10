
export class Contact {

  public id: string;
  public contactName: string;
  public contactEmail: string;
  public subject: string;
  public message: string;
  
  constructor(id?: string,contactName?: string,contactEmail?: string,
    subject?: string,message?: string){
        this.id = id || '';
        this.contactName = contactName || '';
        this.contactEmail = contactEmail || '';
        this.subject = subject || '';
        this.message = message || '';
  }

}
