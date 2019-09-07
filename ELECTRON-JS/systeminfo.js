let output = `
    <h2 class="page-header">App Version</h2>
    <ul class="list-group">
        <li class="list-group-item">
            Node : ${process.versions.node}
        </li>
        <li class="list-group-item">
            Chrome : ${process.versions.chrome}
        </li>
        <li class="list-group-item">
            Electron : ${process.versions.electron}
        </li>
    </ul>

    <h2 class="page-header">System Specs</h2>
    <ul class="list-group">
        <li class="list-group-item">
            System Architecture : ${process.arch}
        </li>
    </ul>

    <h2 class="page-header">Memory Info</h2>
    <ul class="list-group">
        <li class="list-group-item">
            Total Memory : ${process.getSystemMemoryInfo().total}
        </li>
        <li class="list-group-item">
        Free Memory : ${process.getSystemMemoryInfo().free}
        </li>
        <li class="list-group-item">
        Swap Memory : ${process.getSystemMemoryInfo().swapTotal}
        </li>
    </ul>
`;

document.getElementById('output').innerHTML = output;