import {Chips} from '@/domain/Chips';
import {Post} from '@/domain/Post';
import axios from 'axios';
import {AxiosResponse} from 'axios';

import moment from 'moment';

export class TicketService {
  transferttoitem(res: Chips): string[] {
    const item: string[] = [];
    if (res.chip1 != null) {
      item.push(res.chip1);
    }
    if (res.chip2 != null) {
      item.push(res.chip2);
    }
    if (res.chip3 != null) {
      item.push(res.chip3);
    }
    if (res.chip4 != null) {
      item.push(res.chip4);
    }
    if (res.chip5 != null) {
      item.push(res.chip5);
    }
    if (res.chip6 != null) {
      item.push(res.chip6);
    }
    if (res.chip7 != null) {
      item.push(res.chip7);
    }
    if (res.chip8 != null) {
      item.push(res.chip8);
    }
    if (res.chip9 != null) {
      item.push(res.chip9);
    }

    return item;
  }
  imagein(ima: string) {
    return require('@/assets/' + ima);
  }

  public async chargeTicket():Promise<Post[]> {
    let uri = 'http://localhost:8080/api/postule';
    const event: Post[] = [];
    const response = await axios.get(uri, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
    const events: Post[] = [];
    return response.data.map(res=>{
      let myitem: string[] = [];

      myitem = this.transferttoitem(res.chips);
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
        timeformat: moment(res.time).format('LLL'),
        srcimg: res.srcimg,
        dialog: false,
        chipspost: myitem,
        chipspostId: res.chips.id,
        srcimage: varsrcimg.src,
        target: res.target,
        show: false,
        show1: false,
      };
    });
   
  }
}
