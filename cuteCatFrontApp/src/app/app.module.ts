import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { VoteComponentComponent } from './vote/vote.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { ScoreComponent } from './score/score.component';

const routes: Routes = [{
  path: 'home', component: VoteComponentComponent
},
{ path: 'score', component: ScoreComponent },
{ path: '', component: VoteComponentComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    VoteComponentComponent,
    ScoreComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatDialogModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule {
}
