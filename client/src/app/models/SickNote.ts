import { Time } from '@angular/common';
import { Doctor } from './Doctor';
import { Inpatient } from './Inpatient';

export class SickNote {
    public id: number;
    public date: Date;
    public days_rest: number;
    public start_time: Time;
    public end_time: Time;
    public cid: string;
    public details: string;

    public doctor: Doctor;
    public inpatient: Inpatient;
}
