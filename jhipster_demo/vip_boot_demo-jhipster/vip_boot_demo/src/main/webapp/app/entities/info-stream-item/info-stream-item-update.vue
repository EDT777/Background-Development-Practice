<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.infoStreamItem.home.createOrEditLabel" v-text="$t('vip1App.infoStreamItem.home.createOrEditLabel')">Create or edit a InfoStreamItem</h2>
                <div>
                    <div class="form-group" v-if="infoStreamItem.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="infoStreamItem.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.title')" for="info-stream-item-title">Title</label>
                        <input type="text" class="form-control" name="title" id="info-stream-item-title"
                            :class="{'valid': !$v.infoStreamItem.title.$invalid, 'invalid': $v.infoStreamItem.title.$invalid }" v-model="$v.infoStreamItem.title.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.type')" for="info-stream-item-type">Type</label>
                        <input type="text" class="form-control" name="type" id="info-stream-item-type"
                            :class="{'valid': !$v.infoStreamItem.type.$invalid, 'invalid': $v.infoStreamItem.type.$invalid }" v-model="$v.infoStreamItem.type.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.digist')" for="info-stream-item-digist">Digist</label>
                        <input type="text" class="form-control" name="digist" id="info-stream-item-digist"
                            :class="{'valid': !$v.infoStreamItem.digist.$invalid, 'invalid': $v.infoStreamItem.digist.$invalid }" v-model="$v.infoStreamItem.digist.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.content')" for="info-stream-item-content">Content</label>
                        <input type="text" class="form-control" name="content" id="info-stream-item-content"
                            :class="{'valid': !$v.infoStreamItem.content.$invalid, 'invalid': $v.infoStreamItem.content.$invalid }" v-model="$v.infoStreamItem.content.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.createUser')" for="info-stream-item-createUser">Create User</label>
                        <input type="text" class="form-control" name="createUser" id="info-stream-item-createUser"
                            :class="{'valid': !$v.infoStreamItem.createUser.$invalid, 'invalid': $v.infoStreamItem.createUser.$invalid }" v-model="$v.infoStreamItem.createUser.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.lastUpdateDate')" for="info-stream-item-lastUpdateDate">Last Update Date</label>
                        <div class="d-flex">
                            <input id="info-stream-item-lastUpdateDate" type="datetime-local" class="form-control" name="lastUpdateDate" :class="{'valid': !$v.infoStreamItem.lastUpdateDate.$invalid, 'invalid': $v.infoStreamItem.lastUpdateDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.infoStreamItem.lastUpdateDate.$model)"
                            @change="updateZonedDateTimeField('lastUpdateDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.updateUser')" for="info-stream-item-updateUser">Update User</label>
                        <input type="text" class="form-control" name="updateUser" id="info-stream-item-updateUser"
                            :class="{'valid': !$v.infoStreamItem.updateUser.$invalid, 'invalid': $v.infoStreamItem.updateUser.$invalid }" v-model="$v.infoStreamItem.updateUser.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.createDate')" for="info-stream-item-createDate">Create Date</label>
                        <div class="d-flex">
                            <input id="info-stream-item-createDate" type="datetime-local" class="form-control" name="createDate" :class="{'valid': !$v.infoStreamItem.createDate.$invalid, 'invalid': $v.infoStreamItem.createDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.infoStreamItem.createDate.$model)"
                            @change="updateZonedDateTimeField('createDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.tags')" for="info-stream-item-tags">Tags</label>
                        <input type="text" class="form-control" name="tags" id="info-stream-item-tags"
                            :class="{'valid': !$v.infoStreamItem.tags.$invalid, 'invalid': $v.infoStreamItem.tags.$invalid }" v-model="$v.infoStreamItem.tags.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.contentType')" for="info-stream-item-contentType">Content Type</label>
                        <select class="form-control" name="contentType" :class="{'valid': !$v.infoStreamItem.contentType.$invalid, 'invalid': $v.infoStreamItem.contentType.$invalid }" v-model="$v.infoStreamItem.contentType.$model" id="info-stream-item-contentType" >
                            <option value="VIDEO" v-bind:label="$t('vip1App.ItemResourceType.VIDEO')">VIDEO</option>
                            <option value="AUDIO" v-bind:label="$t('vip1App.ItemResourceType.AUDIO')">AUDIO</option>
                            <option value="IMAGE" v-bind:label="$t('vip1App.ItemResourceType.IMAGE')">IMAGE</option>
                            <option value="ARTICAL" v-bind:label="$t('vip1App.ItemResourceType.ARTICAL')">ARTICAL</option>
                            <option value="ACTIVITY" v-bind:label="$t('vip1App.ItemResourceType.ACTIVITY')">ACTIVITY</option>
                            <option value="SINGLE_PRODUCT" v-bind:label="$t('vip1App.ItemResourceType.SINGLE_PRODUCT')">SINGLE_PRODUCT</option>
                            <option value="COVER" v-bind:label="$t('vip1App.ItemResourceType.COVER')">COVER</option>
                            <option value="OTHER" v-bind:label="$t('vip1App.ItemResourceType.OTHER')">OTHER</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.infoStreamItem.author')" for="info-stream-item-author">Author</label>
                        <select class="form-control" id="info-stream-item-author" name="author" v-model="infoStreamItem.authorId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="authorOption.id" v-for="authorOption in authors" :key="authorOption.id">{{authorOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.infoStreamItem.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./info-stream-item-update.component.ts">
</script>
