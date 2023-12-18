import {Fragment, useEffect, useState} from 'react';
import ReactDOM, {Root} from "react-dom/client";


const positionElement = (target: HTMLElement, parent: HTMLElement) => {
  const div = target;

  const parentRect = parent.getBoundingClientRect();
  const divRect = div.getBoundingClientRect();

  const spaceRight = window.innerWidth - (parentRect.right + divRect.width);
  const spaceBelow = window.innerHeight - (parentRect.bottom + divRect.height);

  let cssProperties = {
    x: 0,
    y: 0
  };

  if (spaceRight >= 0) {
    cssProperties.x = Number(parentRect.right);
    cssProperties.y = Number(parentRect.top);
  } else if (spaceBelow >= 0) {
    cssProperties.x = Number(parentRect.left);
    cssProperties.y = Number(parentRect.bottom);
  } else {
    // Position the div to the left or above the parent
    const spaceLeft = parentRect.left - divRect.width;
    const spaceAbove = parentRect.top - divRect.height;

    if (spaceLeft >= 0) {
      cssProperties.x = Number(parentRect.left - divRect.width);
      cssProperties.y = Number(parentRect.top);
    } else if (spaceAbove >= 0) {
      cssProperties.x = Number(parentRect.left);
      cssProperties.y = Number(parentRect.top - divRect.height);
    }
  }

  return cssProperties;
}

export const useContextMenu = () => {
  const [container, setContainer] = useState<Element | null>(null);
  const [root, setRoot] = useState<Root | null>(null);

  useEffect(() => {
    setContainer(prevState => {
      prevState?.remove();
      const element = document.createElement('div');
      document.body.appendChild(element);
      return element;
    });
  }, [setContainer]);

  useEffect(() => {
    if (!container) return;
    setRoot(prevState => {
      prevState?.unmount();
      return ReactDOM.createRoot(container);
    })
  }, [container, setRoot]);

  useEffect(() => {
    document.addEventListener('click', ifClickOutside);
    return () => {
      document.removeEventListener('click', ifClickOutside);
    }
  }, [container, root]);

  const ifClickOutside = (e: MouseEvent) => {
    if (!container?.contains(e.target as any)) {
      root?.render(<Fragment/>);
    }
  }

  const open = (coords: { x: number, y: number }, body: JSX.Element) => {
    if (!container) return;
    root?.render(<div style={{
      position: "absolute",
      top: coords.y,
      left: coords.x,
    }}>
      {body}
    </div>);
  }

  const openAtCursor = (e: MouseEvent, body: JSX.Element) => {
    e.preventDefault();
    const coords = {x: e.clientX, y: e.clientY};
    open(coords, body)
  };

  const close = () => {
    root?.render(<Fragment/>);
  }
  return {
    openAtCursor,
    close,
  }
};