Ext.define('AM.store.Users', {
    extend: 'Ext.data.Store',
    model: 'AM.model.User',
    autoLoad: true,

    proxy: {
        type: 'ajax',
        api: {
            read: 'data/user/read',
            update: 'data/user/update',
            destroy: 'data/user/destroy',
            create: 'data/user/create'
        },
        writer: {
            allowSingle: false /* if not set operations on single records will fail */
        }
    }
});