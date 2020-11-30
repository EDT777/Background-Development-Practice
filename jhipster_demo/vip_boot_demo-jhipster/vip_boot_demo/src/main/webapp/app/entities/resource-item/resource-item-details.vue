<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="resourceItem">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.resourceItem.detail.title')">ResourceItem</span> {{resourceItem.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.type')">Type</span>
                    </dt>
                    <dd>
                        <span v-text="$t('vip1App.ItemResourceType.' + resourceItem.type)">{{resourceItem.type}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.platform')">Platform</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.platform}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.resourceId')">Resource Id</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.resourceId}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.transcodeStatus')">Transcode Status</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.transcodeStatus}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.uploadStatus')">Upload Status</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.uploadStatus}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.updateDate')">Update Date</span>
                    </dt>
                    <dd>
                        <span v-if="resourceItem.updateDate">{{$d(Date.parse(resourceItem.updateDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.auditStatus')">Audit Status</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.auditStatus}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.auditDate')">Audit Date</span>
                    </dt>
                    <dd>
                        <span v-if="resourceItem.auditDate">{{$d(Date.parse(resourceItem.auditDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.auditInfo')">Audit Info</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.auditInfo}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.fileSize')">File Size</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.fileSize}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.contentSize')">Content Size</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.contentSize}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.source')">Source</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.source}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.url')">Url</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.url}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.urlExpire')">Url Expire</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.urlExpire}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.params')">Params</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.params}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.auditUser')">Audit User</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.auditUser}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.delFlag')">Del Flag</span>
                    </dt>
                    <dd>
                        <span>{{resourceItem.delFlag}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.infoStreamItem')">Info Stream Item</span>
                    </dt>
                    <dd>
                        <div v-if="resourceItem.infoStreamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: resourceItem.infoStreamItemId}}">{{resourceItem.infoStreamItemId}}</router-link>
                        </div>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.resourceItem.infoStreamItem')">Info Stream Item</span>
                    </dt>
                    <dd>
                        <div v-if="resourceItem.infoStreamItemId">
                            <router-link :to="{name: 'InfoStreamItemView', params: {infoStreamItemId: resourceItem.infoStreamItemId}}">{{resourceItem.infoStreamItemId}}</router-link>
                        </div>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="resourceItem.id" :to="{name: 'ResourceItemEdit', params: {resourceItemId: resourceItem.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./resource-item-details.component.ts">
</script>
