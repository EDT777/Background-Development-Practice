<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.resourceItem.home.createOrEditLabel" v-text="$t('vip1App.resourceItem.home.createOrEditLabel')">Create or edit a ResourceItem</h2>
                <div>
                    <div class="form-group" v-if="resourceItem.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="resourceItem.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.type')" for="resource-item-type">Type</label>
                        <select class="form-control" name="type" :class="{'valid': !$v.resourceItem.type.$invalid, 'invalid': $v.resourceItem.type.$invalid }" v-model="$v.resourceItem.type.$model" id="resource-item-type" >
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
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.platform')" for="resource-item-platform">Platform</label>
                        <input type="text" class="form-control" name="platform" id="resource-item-platform"
                            :class="{'valid': !$v.resourceItem.platform.$invalid, 'invalid': $v.resourceItem.platform.$invalid }" v-model="$v.resourceItem.platform.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.resourceId')" for="resource-item-resourceId">Resource Id</label>
                        <input type="text" class="form-control" name="resourceId" id="resource-item-resourceId"
                            :class="{'valid': !$v.resourceItem.resourceId.$invalid, 'invalid': $v.resourceItem.resourceId.$invalid }" v-model="$v.resourceItem.resourceId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.transcodeStatus')" for="resource-item-transcodeStatus">Transcode Status</label>
                        <input type="checkbox" class="form-check" name="transcodeStatus" id="resource-item-transcodeStatus"
                            :class="{'valid': !$v.resourceItem.transcodeStatus.$invalid, 'invalid': $v.resourceItem.transcodeStatus.$invalid }" v-model="$v.resourceItem.transcodeStatus.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.uploadStatus')" for="resource-item-uploadStatus">Upload Status</label>
                        <input type="checkbox" class="form-check" name="uploadStatus" id="resource-item-uploadStatus"
                            :class="{'valid': !$v.resourceItem.uploadStatus.$invalid, 'invalid': $v.resourceItem.uploadStatus.$invalid }" v-model="$v.resourceItem.uploadStatus.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.updateDate')" for="resource-item-updateDate">Update Date</label>
                        <div class="d-flex">
                            <input id="resource-item-updateDate" type="datetime-local" class="form-control" name="updateDate" :class="{'valid': !$v.resourceItem.updateDate.$invalid, 'invalid': $v.resourceItem.updateDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.resourceItem.updateDate.$model)"
                            @change="updateZonedDateTimeField('updateDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.auditStatus')" for="resource-item-auditStatus">Audit Status</label>
                        <input type="checkbox" class="form-check" name="auditStatus" id="resource-item-auditStatus"
                            :class="{'valid': !$v.resourceItem.auditStatus.$invalid, 'invalid': $v.resourceItem.auditStatus.$invalid }" v-model="$v.resourceItem.auditStatus.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.auditDate')" for="resource-item-auditDate">Audit Date</label>
                        <div class="d-flex">
                            <input id="resource-item-auditDate" type="datetime-local" class="form-control" name="auditDate" :class="{'valid': !$v.resourceItem.auditDate.$invalid, 'invalid': $v.resourceItem.auditDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.resourceItem.auditDate.$model)"
                            @change="updateZonedDateTimeField('auditDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.auditInfo')" for="resource-item-auditInfo">Audit Info</label>
                        <input type="text" class="form-control" name="auditInfo" id="resource-item-auditInfo"
                            :class="{'valid': !$v.resourceItem.auditInfo.$invalid, 'invalid': $v.resourceItem.auditInfo.$invalid }" v-model="$v.resourceItem.auditInfo.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.fileSize')" for="resource-item-fileSize">File Size</label>
                        <input type="number" class="form-control" name="fileSize" id="resource-item-fileSize"
                            :class="{'valid': !$v.resourceItem.fileSize.$invalid, 'invalid': $v.resourceItem.fileSize.$invalid }" v-model.number="$v.resourceItem.fileSize.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.contentSize')" for="resource-item-contentSize">Content Size</label>
                        <input type="number" class="form-control" name="contentSize" id="resource-item-contentSize"
                            :class="{'valid': !$v.resourceItem.contentSize.$invalid, 'invalid': $v.resourceItem.contentSize.$invalid }" v-model.number="$v.resourceItem.contentSize.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.source')" for="resource-item-source">Source</label>
                        <input type="text" class="form-control" name="source" id="resource-item-source"
                            :class="{'valid': !$v.resourceItem.source.$invalid, 'invalid': $v.resourceItem.source.$invalid }" v-model="$v.resourceItem.source.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.url')" for="resource-item-url">Url</label>
                        <input type="text" class="form-control" name="url" id="resource-item-url"
                            :class="{'valid': !$v.resourceItem.url.$invalid, 'invalid': $v.resourceItem.url.$invalid }" v-model="$v.resourceItem.url.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.urlExpire')" for="resource-item-urlExpire">Url Expire</label>
                        <input type="number" class="form-control" name="urlExpire" id="resource-item-urlExpire"
                            :class="{'valid': !$v.resourceItem.urlExpire.$invalid, 'invalid': $v.resourceItem.urlExpire.$invalid }" v-model.number="$v.resourceItem.urlExpire.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.params')" for="resource-item-params">Params</label>
                        <input type="text" class="form-control" name="params" id="resource-item-params"
                            :class="{'valid': !$v.resourceItem.params.$invalid, 'invalid': $v.resourceItem.params.$invalid }" v-model="$v.resourceItem.params.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.auditUser')" for="resource-item-auditUser">Audit User</label>
                        <input type="number" class="form-control" name="auditUser" id="resource-item-auditUser"
                            :class="{'valid': !$v.resourceItem.auditUser.$invalid, 'invalid': $v.resourceItem.auditUser.$invalid }" v-model.number="$v.resourceItem.auditUser.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.delFlag')" for="resource-item-delFlag">Del Flag</label>
                        <input type="checkbox" class="form-check" name="delFlag" id="resource-item-delFlag"
                            :class="{'valid': !$v.resourceItem.delFlag.$invalid, 'invalid': $v.resourceItem.delFlag.$invalid }" v-model="$v.resourceItem.delFlag.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.infoStreamItem')" for="resource-item-infoStreamItem">Info Stream Item</label>
                        <select class="form-control" id="resource-item-infoStreamItem" name="infoStreamItem" v-model="resourceItem.infoStreamItemId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="infoStreamItemOption.id" v-for="infoStreamItemOption in infoStreamItems" :key="infoStreamItemOption.id">{{infoStreamItemOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.resourceItem.infoStreamItem')" for="resource-item-infoStreamItem">Info Stream Item</label>
                        <select class="form-control" id="resource-item-infoStreamItem" name="infoStreamItem" v-model="resourceItem.infoStreamItemId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="infoStreamItemOption.id" v-for="infoStreamItemOption in infoStreamItems" :key="infoStreamItemOption.id">{{infoStreamItemOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.resourceItem.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./resource-item-update.component.ts">
</script>
