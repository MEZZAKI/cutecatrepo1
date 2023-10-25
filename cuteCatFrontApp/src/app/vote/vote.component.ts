import { Component } from '@angular/core';
import { Cat } from '../models/Cat';
import { MatDialog } from '@angular/material/dialog';
import { CatService } from '../../services/CatService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vote-page-component',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css']
})
export class VoteComponentComponent {
  cats!: Cat[];
  leftCat!: Cat;
  rightCat!: Cat;
  index = 0;
  length = 0;
  constructor(public dialog: MatDialog, private catService: CatService, private router: Router) { }
  ngOnInit() {
    this.catService.getCats().subscribe(
      (returnedCats) => {
        this.cats = returnedCats;
        this.length = returnedCats.length;
        this.leftCat = this.nextCat();
        this.rightCat = this.nextCat();

      }
    );
  }
  leftVote() {
    this.leftCat.score = this.leftCat.score + 1;
    this.rightCat = this.nextCat();
  }
  rightVote() {
    this.rightCat.score = this.rightCat.score + 1;
    this.leftCat = this.nextCat();
  }
  nextCat() {
    this.index < this.length ? this.index++ : this.saveAllCatsAndRedirect();
    return this.cats[this.index];
  }
  saveAllCatsAndRedirect() {
    this.catService.saveCats(this.cats).subscribe(() => this.router.navigate(['/score']));
  }
}
