import { ReactNode } from "react";

interface Props {
    alertType?: "primary" | "warning" | "danger"; // Optional with provided set of values only
    children: ReactNode;
}
const Alert = ({ children, alertType = "primary" }: Props) => {
    return (
        <div className={"alert alert-dismissible alert-" + alertType}>
            {children}
        </div>
    );
};

export default Alert;
