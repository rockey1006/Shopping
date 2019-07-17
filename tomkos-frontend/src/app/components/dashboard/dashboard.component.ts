import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  categories : string[];

  constructor(private apiService : ApiService) { }

  ngOnInit() {
    this.apiService.getAllCategories().subscribe(categoriesFromBackend => this.categories = categoriesFromBackend);
  }

}
