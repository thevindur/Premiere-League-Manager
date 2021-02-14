import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ViewClubsComponent } from './view-clubs/view-clubs.component';
import { ViewMatchesComponent } from './view-matches/view-matches.component';
import {NgMarqueeModule} from "ng-marquee";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ViewClubsComponent,
    ViewMatchesComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        NgMarqueeModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
