import { Features } from "./Features";
import { Offer } from './Offer';

export class OfferData {
  id: number;
  text: string;
  time: Date;
  srcimg: string;
  features: Features;
  target: string;

  constructor(offre: Offer) {
    this.id = offre.id;
    this.text = offre.text.toString();
    this.time = offre.time;
    this.srcimg = offre.srcimg;
    this.features = new Features();
    this.features.transfert(offre.features);
    this.features.id = offre.id;
    this.target = offre.target;
  }
}
