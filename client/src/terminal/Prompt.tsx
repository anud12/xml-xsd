import "./Prompt.css"
import {Cursor} from "./Cursor";

export const Prompt = () => {

  return (
    <div className="terminal__prompt">
      <span className="terminal__prompt--user">fobabs</span>
      <span>@</span>
      <span className="terminal__prompt--machine">ubuntu</span>
      <span>:</span>
      <span className="terminal__prompt--location">demo</span>
      <span className="terminal__prompt--bling">$</span>
      <Cursor/>
    </div>
  )
}