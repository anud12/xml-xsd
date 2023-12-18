import "./Prompt.css"

type Props = {
  user?:string,
  machine?:string,
  location?:string,
}
export const Prompt = (props:Props) => {

  return (
    <div className="terminal__prompt">
      <span className="terminal__prompt--user">{props.user || "root"}</span>
      <span>@</span>
      <span className="terminal__prompt--machine">{props.machine || "ubuntu"}</span>
      <span>:</span>
      <span className="terminal__prompt--location">{props.location || "~"}</span>
      <span className="terminal__prompt--bling">$</span>
    </div>
  )
}