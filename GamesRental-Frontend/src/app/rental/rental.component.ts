import { Component, OnInit } from '@angular/core';
import { Rental } from './rental.model';
import { RentalService } from './rental.service';
import { GameService } from '../game/game.service';
import { Game } from '../game/game.model';
import { CustomerService } from '../customer/customer.service';
import { Customer } from '../customer/customer.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-rental',
  templateUrl: './rental.component.html',
  styleUrls: ['./rental.component.css']
})
export class RentalComponent implements OnInit {

  rentals: Rental[];
  games: Game[];
  customers: Customer[];
  rental: Rental = new Rental();
  rentalForm: Rental = new Rental();
  showForm: Boolean;
  colSizeForm: String;

  initialDate: String;
  finalDate: String;

  constructor(private rentalService: RentalService, 
    private gameService: GameService,
    private customerService: CustomerService, 
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.showForm = false;
    this.getAll();
    this.loadGames();
    this.loadCustomers();
  }

  getAll() {
    this.rentalService.getAll()
      .subscribe((response) => {
        this.rentals = response;
      });
  }
  
  loadCustomers() {
    this.customerService.getAll()
      .subscribe((response) => {
        this.customers = response;
      });
  }
  loadGames() {
    this.gameService.getAll()
      .subscribe((response) => {
        this.games = response;
      });
  }

  selectRental(rentalSelected: Rental) {
    rentalSelected = Object.create(rentalSelected) 
    this.initialDate = new Date(rentalSelected.initialDate).toUTCString();
    this.finalDate = new Date(rentalSelected.finalDate).toUTCString();
    rentalSelected.initialDate = new Date(rentalSelected.initialDate).toJSON().slice(0,-8);
    rentalSelected.finalDate = new Date(rentalSelected.finalDate).toJSON().slice(0,-8);

    rentalSelected.customerId = rentalSelected.customer.id;
    rentalSelected.gameId = rentalSelected.game.id;
    this.rentalForm = rentalSelected;
    this.rental = rentalSelected;
    this.showForm = true;
  }

  formNewRental() {
    this.rentalForm = new Rental();
    this.rental = new Rental();
    console.log(this.rental);
    this.showForm = true;
  }

  onSubmit(rental: Rental) {
    
    this.games.map(game => {
      if(this.rental.gameId==game.id) {
        rental.game = game;
        return game;
      }
    });
    this.customers.map(customer => {
      if(this.rental.customerId==customer.id) {
        rental.customer = customer;
        return customer;
      }
    });
    this.rentalService.add(rental)
    .subscribe(result => {
      this.getAll();
      this.selectRental(result);
      
      this.toastr.show('Rental saved!', 'Success');
    });
  }
  calculatePrice() {
    this.rental.initialDate;
    this.rental.finalDate;
    this.rental.gameId;
    this.games.map(game => {
      if(this.rental.gameId==game.id) {
        this.rental.game = game;
        return game;
      }
    });
    let totalHours = (new Date(this.rental.finalDate).getTime()-new Date(this.rental.initialDate).getTime())/3600000;
    let pricePerHour = this.rental.game.pricePerHour;
    this.rental.totalPrice = totalHours * pricePerHour;
  }
}
