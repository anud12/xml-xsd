import {worldUtilContext} from "../App";
import {Fragment, useContext} from "react";
import {Button} from "./Button";

type Props = {
  onChange: (value: string) => void;
}

export const PersonSelect = (props:Props) => {

  const world = useContext(worldUtilContext);

  return <div className={"PersonSelect"}>
    {world?.json.queryAll("people").flatMap(people => people.queryAll("person")).map(person => {
      return <Fragment key={person.$id}>
        <Button onClick={() => {
          props.onChange(person.$id ?? "");
        }}>
          {person.$name}
        </Button>
        <br/>
      </Fragment>
    })}
  </div>;
}