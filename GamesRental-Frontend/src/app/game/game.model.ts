export class Game {
    id:number;
    name:String;
    availableStock:number;
    pricePerHour:number;
    rentals: Array<Object>;
    platforms : Set<Object>
    directors : Set<Object>
    producers : Set<Object>

}