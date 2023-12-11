import "./Nano.css"
import {Cursor} from "./Cursor";
import {PropsWithChildren} from "react";

type Props = PropsWithChildren

export const Nano = (props:Props) => {
  return <div className={"Nano"}>
    <div className={"Nano_title Nano_float"}>
      <span className={"Nano_appName"}>
        GNU nano 6.2
      </span>
      <span className={"Nano_fileName"}> .bashrc</span>
    </div>

    <div className={"Nano_title"}>
      <span className={"Nano_appName"}>
        GNU nano 6.2
      </span>
      <span className={"Nano_fileName"}> .bashrc</span>
    </div>


    <div className={"Nano_content"} style={{display:"inline-flex"}}>
      {props.children} <Cursor/>
    </div>
    <div className={"Nano_footer Nano_float"}>
      <div className={"Nano_alert"}>
          <div className={"Nano_alert_text"}>
              [ Alert ]
          </div>
      </div>
      <div className={"Nano_menu"}>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
        <span className={"Nano_menu_entry"}>
          <span className={"Nano_menu_key"}>^G</span>
          <span className={"Nano_menu_label"}>Help</span>
        </span>
      </div>
    </div>
  </div>
}