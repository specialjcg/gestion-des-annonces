import {Features} from '@/domain/Features';
import {Offer} from '@/domain/Offer';
import axios from 'axios';

import moment from 'moment';
import {OfferData} from '@/domain/OfferData';

export class OfferService {
         transfertToItems(res: Features): string[] {
           const items: string[] = [];
           if (res.chip1 != null) {
             items.push(res.chip1);
           }
           if (res.chip2 != null) {
             items.push(res.chip2);
           }
           if (res.chip3 != null) {
             items.push(res.chip3);
           }
           if (res.chip4 != null) {
             items.push(res.chip4);
           }
           if (res.chip5 != null) {
             items.push(res.chip5);
           }
           if (res.chip6 != null) {
             items.push(res.chip6);
           }
           if (res.chip7 != null) {
             items.push(res.chip7);
           }
           if (res.chip8 != null) {
             items.push(res.chip8);
           }
           if (res.chip9 != null) {
             items.push(res.chip9);
           }

           return items;
         }
         imagein(ima: string) {
           return require('@/assets/' + ima);
         }

         public async loadOffer(): Promise<Offer[]> {
           let uri = 'http://localhost:8080/api/postule';
          
           const response = await axios.get(uri, {
             headers: {
               'Content-Type': 'application/json',
             },
           });
           
           return response.data.map((res: { features: Features; srcimg: string; id: any; text: string; time: any; target: any; }) => {
             let myitems: string[] = this.transfertToItems(res.features);
             let varsrcimg = new Image();
             let str: string = res.srcimg;
             if (str.includes('/')) {
               varsrcimg = new Image();
             } else {
               varsrcimg.src = this.imagein(res.srcimg);
             }
             return {
               id: res.id,
               text: parseInt(res.text),
               time: res.time,
               timeformat: moment(res.time).format('L'),
               srcimg: res.srcimg,
               dialog: false,
               features: myitems,
               featureId: res.features.id,
               srcimage: varsrcimg.src,
               target: res.target,
               show: false,
               show1: false,
             };
           });
         }
         async addOffer(event: Offer) {
           let uri = 'http://localhost:8080/api/postule';
           let mychip = new OfferData(event);
           var result = JSON.stringify(mychip);
           await axios.post(uri, result, {
             headers: {
               'Content-Type': 'application/json',
             },
           });
         }
         updateOffer(event: Offer) {
          
           if (event.id == 0) {
             this.addOffer(event);
           } else {
             let uri = 'http://localhost:8080/api/postule/' + event.id;
             let newListOfFeatures = new OfferData(event);
             newListOfFeatures.features.id = event.featureId;
             var result = JSON.stringify(newListOfFeatures);

             axios
               .post(uri, result, {
                 headers: {
                   'Content-Type': 'application/json',
                 },
               })
           }
         }
         deleteOffer(event: Offer) {
           let uri = 'http://localhost:8080/api/postule/delete/' + event.id;
           axios.post(uri);
           event.dialog = false;
         }
       }
