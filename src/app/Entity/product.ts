export class product{
    id:number
    name:string
    componyName:string
    quantity:string
    price:string
    constructor(id:number=0,
        name:string="",
        componyName:string="",
        quantity:string="",
        price:string=""){
            this.id=id
            this.name=name
            this.componyName=componyName
            this.quantity=quantity
            this.price=price

    }
    public toJson():any{
        return { id:this.id,name:this.name,componyName:this.componyName,price:this.price,quantity:this.quantity}
        
    }

}