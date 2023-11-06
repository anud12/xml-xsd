import {topAndBottom} from "./topAndBottom";
import {sideBySide} from "./sideBySide";


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
  unsubscribeLeft: () => void,
  unsubscribeRight: () => void,
  unsubscribeTop: () => void,
  unsubscribeBottom: () => void,
  update: (text: string) => void,
  rerender: () => string,
  unsubscribe: () => void,
  onUpdate: (callback: (string:string) => void) => () => void
}

export const render = (): Render => {
  let left: Render | undefined;
  let right: Render | undefined;
  let top: Render | undefined;
  let bottom: Render | undefined;
  let text: string | undefined;
  let updateCallback: ((string: string) => void) | undefined;
  const addLeft = (): Render => {
    left = render();
    left.onUpdate(() => {
      updateCallback?.(rerender());
    })
    return left;
  }
  const addRight = (): Render => {
    right = render();
    right.onUpdate(() => {
      updateCallback?.(rerender());
    })
    return right
  }
  const addTop = (): Render => {
    top = render();
    top.onUpdate(() => {
      updateCallback?.(rerender());
    })
    return top;
  }
  const addBottom = (): Render => {
    bottom = render();
    bottom.onUpdate(() => {
      updateCallback?.(rerender());
    })
    return bottom;
  }

  const unsubscribe: () => void = () => {
    text = undefined;
    left?.unsubscribe();
    left = undefined;
    right?.unsubscribe();
    right = undefined;
    top?.unsubscribe();
    top = undefined;
    bottom?.unsubscribe();
    bottom = undefined;
  };

  const onUpdate = (callback: (string: string) => void): () => void => {
    updateCallback = callback;
    return () => {
      updateCallback = undefined;
    }
  }

  const update = (newText: string): void => {
    text = newText;
    updateCallback?.(rerender());
  }

  const rerender = (): string => {
    const leftText = left?.rerender() || '';
    const rightText = right?.rerender() || '';
    const topText = top?.rerender() || '';
    const bottomText = bottom?.rerender() || '';
    return topAndBottom(topText, topAndBottom(sideBySide(leftText, sideBySide(text || '', rightText)), bottomText));
  }
  const unsubscribeLeft = (): void => {
    left.unsubscribe();
    left = undefined;
  }
  const unsubscribeRight = (): void => {
    right.unsubscribe();
    right = undefined;
  }
  const unsubscribeTop = (): void => {
    top.unsubscribe();
    top = undefined;
  }
  const unsubscribeBottom = (): void => {
    bottom.unsubscribe();
    bottom = undefined;
  }
  return {
    addLeft,
    addRight,
    addTop,
    addBottom,
    unsubscribeLeft,
    unsubscribeRight,
    unsubscribeTop,
    unsubscribeBottom,
    update,
    rerender,
    onUpdate,
    unsubscribe
  }
}