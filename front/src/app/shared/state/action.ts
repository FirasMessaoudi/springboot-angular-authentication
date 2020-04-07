export class AddUser {
    static readonly type = '[USER] Add'

    constructor(public user: any) {}
}

export class RemoveUser {
    static readonly type = '[USER] Remove'

    constructor(public id: number) {}
}
export class Reset {
    static readonly type = '[USER] Reset'

    constructor() {}
}