import "./FileUpload.css";
import {useEffect, useState} from "react";

type Props = {
  file?: File,
  managed?: boolean,
  label?: string,
  onChange: (file: File) => void
}

export const FileUpload = (props: Props) => {

  const [state, setState] = useState<File | undefined>()

  return (
    <label className={"FileUpload"}>
      {props.label ?? props.file?.name ?? state?.name ?? "No file"}
      <input className={"FileUpload__input"} type={"file"} onChange={event => {
        const file = event.target.files?.[0] as any;
        setState(file)
        props.onChange(file)
      }}/>
    </label>
  )
}