import { ListFilterPipe } from './classes/list-filter-pipe';
import { AuthguardService } from './services/authguard.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgxSpinnerModule } from 'ngx-spinner';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { MenuComponent } from './components/menu/menu.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ListViewStudentRegisterComponent } from './components/list-view-student-register/list-view-student-register.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MessageAfterRegistrationComponent } from './components/message-after-registration/message-after-registration.component';
import { ViewDetailsStudentComponent } from './components/view-details-student/view-details-student.component';
import { SaveRequestNoteComponent } from './components/save-request-note/save-request-note.component';


const routes: Routes = [
  { path: '', component:  LoginComponent},
  { path: 'menu', canActivate: [AuthguardService], component:  MenuComponent},
  { path: 'message', component: MessageAfterRegistrationComponent},
  { path: 'student/:matricule', component: ViewDetailsStudentComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    ListViewStudentRegisterComponent,
    ListFilterPipe,
    MessageAfterRegistrationComponent,
    ViewDetailsStudentComponent,
    SaveRequestNoteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxSpinnerModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes),
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
