import { Features } from './Features';
import { Offre } from './Offre';

export class Offrejson {
  id: number;
  text: string;
  time: Date;
  srcimg: string;
  features: Features;
  target: string;

  constructor(offre: Offre) {
    this.id = offre.id;
    this.text = offre.text.toString();
    this.time = offre.time;
    this.srcimg = offre.srcimg;
    this.features = new Features();
    this.features.transfert(offre.listfeature);
    this.features.id = offre.id;
    this.target = offre.target;
  }
}
