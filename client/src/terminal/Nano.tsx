import "./Nano.css"
import {Fragment, PropsWithChildren, ReactNode} from "react";

type Props = PropsWithChildren & {
  appName?: string,
  fileName?: string,
  alert?: string,
  menu?: Array<{
    key: string,
    label: ReactNode,
  }>
}

export const Nano = (props: Props) => {
  return <div className={"Nano"}>
    <div className={"Nano_title Nano_float"}>
      <span className={"Nano_appName"}>
        {props?.appName}
      </span>
      <span className={"Nano_fileName"}>
        {props?.fileName || "\u00A0"}
      </span>
    </div>

    <div className={"Nano_content"}>
      {props?.children}
    </div>


    <div className={"Nano_footer Nano_float"}>
      <div className={"Nano_alert"}>
        <div className={"Nano_alert_text"}>
          {props?.alert && <Fragment>[ {props.alert} ]</Fragment>}
        </div>
      </div>
      <div className={"Nano_menu"}>
        {props?.menu?.map((value, index) => (
          <span key={index} className={"Nano_menu_entry"}>
            <span className={"Nano_menu_key"}>{value.key}</span>
            <span className={"Nano_menu_label"}>{value.label}</span>
          </span>
        ))}
      </div>
    </div>
  </div>
}