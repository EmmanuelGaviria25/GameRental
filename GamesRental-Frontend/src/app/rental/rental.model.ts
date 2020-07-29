import { Game } from '../game/game.model';
import { Customer } from '../customer/customer.model';

export class Rental {
    id:number;
    initialDate:any;
    finalDate:any;
    totalPrice:number;
    status:Boolean = true;
    game:Game;
    gameId:number = null;
    customer:Customer;
    customerId:number =null;
}