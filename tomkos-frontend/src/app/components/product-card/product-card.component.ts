import { Component, OnInit, Input } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ApiService } from 'src/app/service/api.service';
import { Cartitem } from 'src/app/model/cartitem';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  @Input('product') product : Product;


  constructor(private apiService : ApiService) { }

  ngOnInit() {
  }

  addToCart(amount : number) {
    
    let cartItem = {
      productId : this.product.id,
      amount : amount
    }
     

    this.apiService.addToCart(cartItem).subscribe();
  }
}
