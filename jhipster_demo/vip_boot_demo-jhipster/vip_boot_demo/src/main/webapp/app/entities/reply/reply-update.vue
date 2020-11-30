<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.reply.home.createOrEditLabel" v-text="$t('vip1App.reply.home.createOrEditLabel')">Create or edit a Reply</h2>
                <div>
                    <div class="form-group" v-if="reply.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="reply.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.title')" for="reply-title">Title</label>
                        <input type="text" class="form-control" name="title" id="reply-title"
                            :class="{'valid': !$v.reply.title.$invalid, 'invalid': $v.reply.title.$invalid }" v-model="$v.reply.title.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.content')" for="reply-content">Content</label>
                        <input type="text" class="form-control" name="content" id="reply-content"
                            :class="{'valid': !$v.reply.content.$invalid, 'invalid': $v.reply.content.$invalid }" v-model="$v.reply.content.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.auditStatus')" for="reply-auditStatus">Audit Status</label>
                        <input type="checkbox" class="form-check" name="auditStatus" id="reply-auditStatus"
                            :class="{'valid': !$v.reply.auditStatus.$invalid, 'invalid': $v.reply.auditStatus.$invalid }" v-model="$v.reply.auditStatus.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.createData')" for="reply-createData">Create Data</label>
                        <div class="d-flex">
                            <input id="reply-createData" type="datetime-local" class="form-control" name="createData" :class="{'valid': !$v.reply.createData.$invalid, 'invalid': $v.reply.createData.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.reply.createData.$model)"
                            @change="updateZonedDateTimeField('createData', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.auditDate')" for="reply-auditDate">Audit Date</label>
                        <div class="d-flex">
                            <input id="reply-auditDate" type="datetime-local" class="form-control" name="auditDate" :class="{'valid': !$v.reply.auditDate.$invalid, 'invalid': $v.reply.auditDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.reply.auditDate.$model)"
                            @change="updateZonedDateTimeField('auditDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.createUser')" for="reply-createUser">Create User</label>
                        <input type="text" class="form-control" name="createUser" id="reply-createUser"
                            :class="{'valid': !$v.reply.createUser.$invalid, 'invalid': $v.reply.createUser.$invalid }" v-model="$v.reply.createUser.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.auditUser')" for="reply-auditUser">Audit User</label>
                        <input type="number" class="form-control" name="auditUser" id="reply-auditUser"
                            :class="{'valid': !$v.reply.auditUser.$invalid, 'invalid': $v.reply.auditUser.$invalid }" v-model.number="$v.reply.auditUser.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.replyUserId')" for="reply-replyUserId">Reply User Id</label>
                        <input type="number" class="form-control" name="replyUserId" id="reply-replyUserId"
                            :class="{'valid': !$v.reply.replyUserId.$invalid, 'invalid': $v.reply.replyUserId.$invalid }" v-model.number="$v.reply.replyUserId.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.replyUserNickName')" for="reply-replyUserNickName">Reply User Nick Name</label>
                        <input type="text" class="form-control" name="replyUserNickName" id="reply-replyUserNickName"
                            :class="{'valid': !$v.reply.replyUserNickName.$invalid, 'invalid': $v.reply.replyUserNickName.$invalid }" v-model="$v.reply.replyUserNickName.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.delFlag')" for="reply-delFlag">Del Flag</label>
                        <input type="checkbox" class="form-check" name="delFlag" id="reply-delFlag"
                            :class="{'valid': !$v.reply.delFlag.$invalid, 'invalid': $v.reply.delFlag.$invalid }" v-model="$v.reply.delFlag.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.replyTo')" for="reply-replyTo">Reply To</label>
                        <select class="form-control" id="reply-replyTo" name="replyTo" v-model="reply.replyToId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="replyOption.id" v-for="replyOption in replies" :key="replyOption.id">{{replyOption.id}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.reply.item')" for="reply-item">Item</label>
                        <select class="form-control" id="reply-item" name="item" v-model="reply.itemId">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="infoStreamItemOption.id" v-for="infoStreamItemOption in infoStreamItems" :key="infoStreamItemOption.id">{{infoStreamItemOption.id}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.reply.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./reply-update.component.ts">
</script>
