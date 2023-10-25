import { Component } from '@angular/core';
import { CatService } from '../../services/CatService';
import { Cat } from '../models/Cat';

@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.css']
})
export class ScoreComponent {

  constructor(private catService: CatService) { }
  cats: Cat[] = [];
  ngOnInit() {
    this.catService.getCats().subscribe(
      // sort cats by their score
      (returnedCats) => this.cats = returnedCats.sort((firstCat: Cat, secondCat: Cat) => secondCat.score - firstCat.score));
  }
  resetScoreAllCats() {
    this.catService.resetScoreAllCats().subscribe((returnedCats) => this.cats = returnedCats);
  }
}
