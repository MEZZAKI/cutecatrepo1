import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cat } from '../app/models/Cat';
const httpOptions = {
    headers: new HttpHeaders(
        {
            'Content-Type': 'application/json',
        }
    )
};
const backendUrl = "https://cutecatbnd-0318a7fe6f82.herokuapp.com";
const catsApiUrl = backendUrl + "/cats";

@Injectable({
    providedIn: 'root'
})
export class CatService {
    constructor(private http: HttpClient) { }
    public getCats(): Observable<Cat[]> {
        return this.http.get<Cat[]>(catsApiUrl + "/getAll", httpOptions);
    }
    public saveCats(cats: Cat[]): Observable<Cat[]> {
        return this.http.post<Cat[]>(catsApiUrl + "/saveAll", cats, httpOptions);
    }
    public resetScoreAllCats(): Observable<Cat[]> {
        return this.http.get<Cat[]>(catsApiUrl + "/resetScoreAllCats", httpOptions);
    }
}