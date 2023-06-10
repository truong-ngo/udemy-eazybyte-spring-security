
export class Loans {

  public loanNumber: number;
  public userId: number;
  public startDate: Date;
  public loanType: string;
  public totalLoan: number;
  public amountPaid: number;
  public outstandingAmount: number;
  
  constructor(loanNumber?: number,customerId?: number,startDate?: Date, loanType?: string,
    totalLoan?: number,amountPaid?: number, outstandingAmount?: number){
        this.loanNumber = loanNumber || 0;
        this.userId = customerId || 0;
        this.startDate = startDate!;
        this.loanType = loanType || "";
        this.totalLoan = totalLoan || 0;
        this.amountPaid = amountPaid || 0;
        this.outstandingAmount = outstandingAmount || 0;
  }

}
