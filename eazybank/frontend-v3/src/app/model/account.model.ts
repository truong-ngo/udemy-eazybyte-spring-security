
export class Account {

  public userId: number;
  public accountNumber: number;
  public accountType: string;
  public branchAddress: string;
  

  constructor(userId?: number,accountNumber?: number,accountType?: string, branchAddress?: string){
        this.userId = userId || 0;
        this.accountNumber = accountNumber || 0;
        this.accountType = accountType || '';
        this.branchAddress = branchAddress || '';
  }

}
