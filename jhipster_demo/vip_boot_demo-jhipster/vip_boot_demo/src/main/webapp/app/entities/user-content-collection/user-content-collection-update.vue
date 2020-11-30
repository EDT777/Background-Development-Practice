<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.userContentCollection.home.createOrEditLabel" v-text="$t('vip1App.userContentCollection.home.createOrEditLabel')">Create or edit a UserContentCollection</h2>
                <div>
                    <div class="form-group" v-if="userContentCollection.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="userContentCollection.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.userContentCollection.userId')" for="user-content-collection-userId">User Id</label>
                        <input type="number" class="form-control" name="userId" id="user-content-collection-userId"
                            :class="{'valid': !$v.userContentCollection.userId.$invalid, 'invalid': $v.userContentCollection.userId.$invalid }" v-model.number="$v.userContentCollection.userId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.userContentCollection.platform')" for="user-content-collection-platform">Platform</label>
                        <input type="text" class="form-control" name="platform" id="user-content-collection-platform"
                            :class="{'valid': !$v.userContentCollection.platform.$invalid, 'invalid': $v.userContentCollection.platform.$invalid }" v-model="$v.userContentCollection.platform.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.userContentCollection.link')" for="user-content-collection-link">Link</label>
                        <input type="text" class="form-control" name="link" id="user-content-collection-link"
                            :class="{'valid': !$v.userContentCollection.link.$invalid, 'invalid': $v.userContentCollection.link.$invalid }" v-model="$v.userContentCollection.link.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.userContentCollection.createDate')" for="user-content-collection-createDate">Create Date</label>
                        <div class="d-flex">
                            <input id="user-content-collection-createDate" type="datetime-local" class="form-control" name="createDate" :class="{'valid': !$v.userContentCollection.createDate.$invalid, 'invalid': $v.userContentCollection.createDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.userContentCollection.createDate.$model)"
                            @change="updateZonedDateTimeField('createDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.userContentCollection.pctUrl')" for="user-content-collection-pctUrl">Pct Url</label>
                        <input type="text" class="form-control" name="pctUrl" id="user-content-collection-pctUrl"
                            :class="{'valid': !$v.userContentCollection.pctUrl.$invalid, 'invalid': $v.userContentCollection.pctUrl.$invalid }" v-model="$v.userContentCollection.pctUrl.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.userContentCollection.valid')" for="user-content-collection-valid">Valid</label>
                        <input type="checkbox" class="form-check" name="valid" id="user-content-collection-valid"
                            :class="{'valid': !$v.userContentCollection.valid.$invalid, 'invalid': $v.userContentCollection.valid.$invalid }" v-model="$v.userContentCollection.valid.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.userContentCollection.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./user-content-collection-update.component.ts">
</script>
