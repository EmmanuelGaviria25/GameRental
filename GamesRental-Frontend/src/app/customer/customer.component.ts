import { Component, OnInit } from '@angular/core';
import { CustomerService } from './customer.service';
import { Customer } from './customer.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers: Customer[];
  customer: Customer = new Customer();
  customerForm: Customer = new Customer();
  showForm: Boolean;
  colSizeForm: String;
  constructor(private customerService: CustomerService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.showForm = false;
    this.getAll();
  }

  getAll() {
    this.customerService.getAll()
      .subscribe((response) => {
        this.customers = response;
      });
  }

  selectCustomer(customerSelected: Customer) {
    this.customerForm = Object.create(customerSelected);
    this.customer = Object.create(customerSelected);
    this.showForm = true;
  }

  formNewCustomer() {
    this.customerForm = new Customer();
    this.customer = new Customer();
    this.showForm = true;
  }

  onSubmit(customer: Customer) {
    this.customerService.add(customer)
      .subscribe(result => {
        this.getAll();
        this.customer = Object.create(result);
        this.toastr.show('Customer saved!', 'Success');
      });
  }
}
