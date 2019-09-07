const {app, BrowserWindow} = require('electron');
const path = require('path');
const url = require('url');

/** Global Variable to avoid windows getting deleted by Garbage Collector*/
let win;

function createWindow(){
    /** Instanciate Browser Window */
    win = new BrowserWindow({
        // Set Width ow window
        width:800, 

        // Set height of window
        height:600, 

        // Set icon for window
        icon: __dirname+'/img/gear.png',

        // Set web preference to true for running js in index.html
        webPreferences: {
            nodeIntegration: true
        }
    });

    /** Load Index HTML file */
    win.loadURL(url.format({
        /** Set path of URL */
        pathname : path.join(__dirname, 'index.html'),
        /** Set Protocol of URL */
        protocol : 'file',
        /** Set slashes */
        slashes : true
    }));

    // Open Devtools
    win.webContents.openDevTools();

    // Set win to null when app is closed
    win.on('closed', () => {
        win = null;
    });
}

// Call createWindow hook for app
app.on('ready', createWindow);

app.on('windows-all-closed', () => {
    if(process.platform !== 'darwin'){
        app.quit();
    }
});