import { ReactNode } from "react";

interface Props {
    alertType: string;
    children: ReactNode;
}
const Alert = ({ alertType, children }: Props) => {
    return <div className={"alert alert-" + alertType}>{children}</div>;
};

export default Alert;
