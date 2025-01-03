import { useState } from "react";

interface Props {
    items: string[];
    heading: string;
    onSelected: (item: string) => void;
}

export default function ListGroup({ items, heading, onSelected }: Props) {
    const [selectedItem, setSelectedItem] = useState(-1);

    return (
        <>
            <h2>{heading}</h2>
            {items.length === 0 && <p>No Items</p>}
            <ul className="list-group">
                {items.map((item, index) => (
                    <li
                        key={item}
                        className={
                            selectedItem === index
                                ? "list-group-item active"
                                : "list-group-item"
                        }
                        onClick={() => {
                            setSelectedItem(index);
                            onSelected(item);
                        }}
                    >
                        {item}
                    </li>
                ))}
            </ul>
        </>
    );
}
