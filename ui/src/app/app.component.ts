import { Component, Injectable, AfterViewInit, Inject } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: `./app.component.html`,
  styleUrls: ['./app.component.css']
})

@Injectable({
  providedIn: 'root'
})
export class AppComponent implements AfterViewInit{
  public devices: any[];
  private title: string;

  constructor(private http: HttpClient, @Inject(DOCUMENT) private document: Document){
    this.devices = [];
    this.title =  'Eaton TechDemo';
  }

  getDevicesMetrics(){
    this.http.get("http://localhost:8080/devices/getDevices").subscribe(data => {
                                                                                   this.devices = JSON.parse(JSON.stringify(data));
                                                                                   console.log('message::::', this.devices);
                                                                                 });
  }

  ngOnInit() {
    console.log("Initializing App...");
    this.getDevicesMetrics();
    console.log("Initialized.");
  }

  reload() {
    this.document.location.reload();
  };

  ngAfterViewInit(){
    setTimeout(() => {
      this.reload();
    }, 2000);
  }

}
