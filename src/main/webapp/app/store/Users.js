Ext.define('AM.store.Users', {
    extend: 'Ext.data.Store',
    model: 'AM.model.User',
    autoLoad: true,
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'data/read.json',
            update: 'data/update.json',
            destroy: 'data/destroy.json'
        },
        reader: {
            type: 'json'
        }
    }
});