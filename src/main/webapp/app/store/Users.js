Ext.define('AM.store.Users', {
    extend: 'Ext.data.Store',

    model: 'AM.model.User',
//    autoLoad: true,
    leadingBufferZone: 0,
    pageSize: 10,
    buffered: true,
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