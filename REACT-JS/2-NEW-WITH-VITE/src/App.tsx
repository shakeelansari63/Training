import ListGroup from "./components/ListGroup";
export default function App() {
    const cities: string[] = ["Mumbai", "Pune", "Tokyo", "Paris", "New York"];
    const handleSelect = (item: string) => console.log(item);
    return (
        <div>
            <ListGroup
                items={cities}
                heading="Cities"
                onSelected={handleSelect}
            />
        </div>
    );
}
