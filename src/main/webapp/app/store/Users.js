Ext.define('AM.store.Users', {
    extend: 'Ext.data.Store',
    model: 'AM.model.User',
    autoLoad: true,

    proxy: {
        type: 'ajax',
        api: {
            read: 'data/read.json',
            update: 'data/update.json',
            destroy: 'data/destroy.json',
            create: 'data/create.json'
        },
        writer: {
            allowSingle: false /* if not set operations on single records will fail */
        }
    }
});