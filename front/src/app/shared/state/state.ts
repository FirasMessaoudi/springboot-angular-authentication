import { State, Action, StateContext, Selector } from '@ngxs/store';
import { AddUser, RemoveUser, Reset } from './action';

export class UserStateModel {
    users: any[];
}
const defaults: UserStateModel = {
    users: [],
  };
@State<UserStateModel>({
    name: 'users',
    defaults: {
        users: []
    }
})

export class UserState {

    @Selector()
    static getUsers(state: UserStateModel) {
        return state.users;
    }

    @Action(AddUser)
    add({getState, patchState }: StateContext<UserStateModel>, { user }:AddUser) {
        const state = getState();
        patchState({
            users: [...state.users, user]
        })
    }

    @Action(RemoveUser)
    remove({getState, patchState }: StateContext<UserStateModel>, { id }:RemoveUser) {
        patchState({
            users: getState().users.filter(a => a.regId != id)
        })
    }
    @Action(Reset)
    reset(context : StateContext<UserStateModel>, { }:Reset) {
        context.setState({...defaults});
    }


}