Ext.define('AM.store.Users', {
    extend: 'Ext.data.Store',

    model: 'AM.model.User',
    autoLoad: true,
    buffered: true,
    leadingBufferZone: 200,
    pageSize: 100,
    proxy: {
        type: 'ajax',
        api: {
            read: 'data/user/read',
            update: 'data/user/update',
            destroy: 'data/user/destroy',
            create: 'data/user/create'
        },
        reader: {
            type: 'json',
            root: 'items',
            totalProperty: 'total'
        },
        writer: {
            allowSingle: false /* if not set operations on single records will fail */
        }
    }
});