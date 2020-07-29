import { Routes } from '@angular/router';

import { GameComponent } from '../../game/game.component';
import { RentalComponent } from '../../rental/rental.component';
import { CustomerComponent } from '../../customer/customer.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'game',      component: GameComponent },
    { path: 'customer',   component: CustomerComponent },
    { path: 'rental',   component: RentalComponent }
];
