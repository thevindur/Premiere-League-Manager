import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ViewClubsComponent } from './view-clubs/view-clubs.component';
import { ViewMatchesComponent } from './view-matches/view-matches.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'viewClub',
    component: ViewClubsComponent
  },
  {
    path: 'viewMatch',
    component: ViewMatchesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
