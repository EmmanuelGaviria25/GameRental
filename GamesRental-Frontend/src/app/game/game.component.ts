import { Component, OnInit } from '@angular/core';
import { Game } from './game.model';
import { GameService } from './game.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  games: Game[];
  game: Game = new Game();
  gameForm: Game = new Game();
  showForm: Boolean;
  colSizeForm: String;
  constructor(private gameService: GameService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.showForm = false;
    this.getAll();
  }

  getAll() {
    this.gameService.getAll()
      .subscribe((response) => {
        this.games = response;
      });
  }

  selectGame(gameSelected: Game) {
    this.gameForm = Object.create(gameSelected);
    this.game = Object.create(gameSelected);
    this.showForm = true;
  }

  formNewGame() {
    this.gameForm = new Game();
    this.game = new Game();
    this.showForm = true;
  }

  onSubmit(game: Game) {
    this.gameService.add(game)
    .subscribe(result => {
      this.getAll();
      this.game = Object.create(result);
      this.toastr.show('Game saved!', 'Success');
    });
  }
}
