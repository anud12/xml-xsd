import {topAndBottom} from "./topAndBottom";
import {sideBySide} from "./sideBySide";
import {left} from "inquirer/lib/utils/readline";
import {addBorder} from "./addBorder";


/*
i want to add a function that creates an object that has a render function that prints the text on
console while also being able to add text to the left or right using sideBySide, and top and bottom
with topAndBottom after adding the text it should return an object that allows to update that portion of
text, and a function that unsubscribes the added text
 */

export type Render = {
  addLeft: () => Render,
  addRight: () => Render,
  addTop: () => Render,
  addBottom: () => Render,
  getLeft: () => Render | undefined,
  getRight: () => Render | undefined,
  getTop: () => Render | undefined,
  getBottom: () => Render | undefined,
  getParent: () => Render| undefined,
  unsubscribeLeft: () => void,
  unsubscribeRight: () => void,
  unsubscribeTop: () => void,
  unsubscribeBottom: () => void,
  update: (...text: string[]) => void,
  rerender: () => string,
  unsubscribe: () => void,
  onUpdate: (callback: (string:string) => void) => () => void
  onFocusChange: (render?:Render[]) => void,
  focus: () => Render,
}

class Renderer implements Render{
  left: Render | undefined;
  right: Render | undefined;
  top: Render | undefined;
  bottom: Render | undefined;
  text: string[] | undefined;
  updateCallback: ((string: string) => void) | undefined;
  focusValue = false;

  constructor(public parent?:Render) {
  }

  getLeft = ():Render | undefined => this.left
  getRight = ():Render | undefined => this.right
  getTop = ():Render | undefined => this.top
  getBottom = ():Render | undefined => this.bottom
  getParent = ():Render | undefined => this.parent

  addLeft = (): Render => {
    this.left = createRender(this);
    this.left.onUpdate(() => {
      this.updateCallback?.(this.rerender());
    })
    return this.left;
  }
  addRight = (): Render => {
    this.right = createRender(this);
    this.right.onUpdate(() => {
      this.updateCallback?.(this.rerender());
    })
    return this.right
  }
  addTop = (): Render => {
    this.top = createRender(this);
    this.top.onUpdate(() => {
      this.updateCallback?.(this.rerender());
    })
    return this.top;
  }
  addBottom = (): Render => {
    this.bottom = createRender(this);
    this.bottom.onUpdate(() => {
      this.updateCallback?.(this.rerender());
    })
    return this.bottom;
  }

  unsubscribe: () => void = () => {
    this.text = undefined;
    this.left?.unsubscribe();
    this.left = undefined;
    this.right?.unsubscribe();
    this.right = undefined;
    this.top?.unsubscribe();
    this.top = undefined;
    this.bottom?.unsubscribe();
    this.bottom = undefined;
  };

  onUpdate = (callback: (string: string) => void): () => void => {
    this.updateCallback = callback;
    return () => {
      this.updateCallback = undefined;
    }
  }

  update = (...newText: string[]): void => {
    this.text = newText;
    this.updateCallback?.(this.rerender());
  }

  rerender = (): string => {
    const leftText = this.left?.rerender() || '';
    const rightText = this.right?.rerender() || '';
    const topText = this.top?.rerender() || '';
    const bottomText = this.bottom?.rerender() || '';

    return sideBySide(leftText, sideBySide(topAndBottom(topText, topAndBottom(addBorder(this.text?.join(), this.focusValue) || '', bottomText)), rightText));
    // return topAndBottom(topText, topAndBottom(sideBySide(leftText, sideBySide(text || '', rightText)), bottomText));
  }
  unsubscribeLeft = (): void => {
    this.left?.unsubscribe();
    this.left = undefined;
  }
  unsubscribeRight = (): void => {
    this.right?.unsubscribe();
    this.right = undefined;
  }
  unsubscribeTop = (): void => {
    this.top?.unsubscribe();
    this.top = undefined;
  }
  unsubscribeBottom = (): void => {
    this.bottom?.unsubscribe();
    this.bottom = undefined;
  }
  onFocusChange = (origin:Render[]): void => {
    const commands = [];
    if(!origin.includes(this.left)) {
      origin.push(this.left);
      commands.push(() => this.left?.onFocusChange(origin));

    }
    if(!origin.includes(this.right)) {
      origin.push(this.right);
      commands.push(() => this.right?.onFocusChange(origin));

    }
    if(!origin.includes(this.top)) {
      origin.push(this.top);
      commands.push(() => this.top?.onFocusChange(origin));
    }
    if(!origin.includes(this.bottom)) {
      origin.push(this.bottom);
      commands.push(() => this.bottom?.onFocusChange(origin));
    }
    if(!origin.includes(this.parent)) {
      origin.push(this.parent);
      commands.push(() => this.parent?.onFocusChange(origin));
    }
    commands.forEach(e => e());
    this.focusValue = false;
  }
  focus = () => {
    this.focusValue = true;
    this.left?.onFocusChange([this]);
    this.right?.onFocusChange([this]);
    this.top?.onFocusChange([this]);
    this.bottom?.onFocusChange([this]);
    this.parent?.onFocusChange([this]);
    return this;
  }
}

export const createRender = (parent?:Render): Render => {
  return new Renderer(parent);
}