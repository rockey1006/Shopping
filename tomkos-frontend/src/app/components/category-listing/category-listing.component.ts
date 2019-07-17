import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/Product';
import { ApiService } from 'src/app/service/api.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-category-listing',
  templateUrl: './category-listing.component.html',
  styleUrls: ['./category-listing.component.css']
})
export class CategoryListingComponent implements OnInit {

  products : Product[];

  constructor(private route: ActivatedRoute, private apiService : ApiService) { }

  ngOnInit() {
    const selectedCategory = this.route.snapshot.paramMap.get('category');
    this.getProductsByCategory(selectedCategory);
  }


  public getProductsByCategory(selectedCategory : string){
      this.apiService.getByCategory(selectedCategory).subscribe(categoryProducts => this.products = categoryProducts);
  }
}
