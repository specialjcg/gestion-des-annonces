import { Chips } from './Chips';
import { Post } from './Post';

export class Postjson {
    id: number;
    text: string;
    time: Date;
    srcimg: string;
    chips: Chips;
    target: string;
  
    constructor(post: Post) {
      this.id = post.id;
      this.text = post.text.toString();
      this.time = post.time;
      this.srcimg = post.srcimg;
      this.chips = new Chips();
      this.chips.transfert(post.chipspost);
      this.chips.id = post.id;
      this.target = post.target;
    }
  }